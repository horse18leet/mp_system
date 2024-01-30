package org.vyatsu.seo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String pathO = "tree.json";

    public static void main(String[] args) {
        TreeMap<String, Integer> searchTree = null;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать новое дерево");
            System.out.println("2. Искать по ключу");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    createNewTree();
                    break;
                case 2:
                    if(searchTree == null){
                        System.out.println("Инициализация дерева по пути: " + pathO);
                        searchTree = deserializeTree(pathO);
                        System.out.println("Дерево инициализировано успешно");
                    }

                    System.out.println("Дерево найдено");
                    System.out.println("Ключевой запрос: ");
                    String query = scanner.nextLine();
                    List<String> results = findAndPrintMatchingEntries(searchTree, query, 1000);

                    long startTime = System.currentTimeMillis();

//                    for(String res : results){
//                        Position.getPositionBySupplierAndQuery(res, "ИП Глухих");
//                    }

                    int numThreads = 30;

                    // Разделение результатов на подсписки для каждого потока
                    List<List<String>> partitionedResults = partitionResults(results, numThreads);

                    // Создание ExecutorService с фиксированным числом потоков
                    ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

                    // Обработка каждого подсписка в отдельном потоке
                    for (List<String> partition : partitionedResults) {
                        executorService.submit(() -> processResults(partition));
                    }

                    // Ожидание завершения всех потоков
                    executorService.shutdown();

                    try {
                        if (!executorService.awaitTermination(100, TimeUnit.SECONDS)) {
                            // Если через 100 секунд потоки еще не завершились, можно выполнить дополнительные действия
                        }
                    } catch (InterruptedException e) {
                        // Обработка исключения
                    }

                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    System.out.println("Время парсинга: " + elapsedTime + " миллисекунд");
                    break;
                case 3:
                    break;
            }

        }
    }

    private static void processResults(List<String> results) {
        for (String res : results) {
            Position.getPositionBySupplierAndQuery(res, "ИП Глухих");
        }
    }

    // Метод для разделения списка на подсписки
    private static <T> List<List<T>> partitionResults(List<T> list, int numPartitions) {
        int size = list.size();
        int partitionSize = (size + numPartitions - 1) / numPartitions;

        return Stream.iterate(0, i -> i + 1)
                .limit(numPartitions)
                .map(i -> list.subList(i * partitionSize, Math.min((i + 1) * partitionSize, size)))
                .collect(Collectors.toList());
    }

    public static TreeMap<String, Integer> createNewTree(){

        TreeMap<String, Integer> searchTree = new TreeMap<>();

        try (FileInputStream fileInputStream = new FileInputStream("C:/requests.xlsx")) {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Предполагается, что данные находятся в первом листе
            System.out.println("Инициализация xlsx");
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Cell cell = row.getCell(0);

                String[] parts = getStringValue(cell).split(",");
                if (parts.length > 1) {
                    System.out.println(parts[1]);
                }

                if (parts.length == 2) {
                    String query = parts[0].trim();
                    int count = Integer.parseInt(parts[1].trim());

                    addSearchQuery(searchTree, query, count);
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        serializeTree(searchTree, pathO);
        System.out.println("Файл успешно записан по пути: " + pathO);

        return searchTree;
    }

    private static void addSearchQuery(TreeMap<String, Integer> searchTree, String query, int count) {
        searchTree.put(query, count);
    }

    private static int getSearchQuery(TreeMap<String, Integer> searchTree, String query) {
        return searchTree.getOrDefault(query, 0);
    }

    private static void serializeTree(TreeMap<String, Integer> searchTree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(searchTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TreeMap<String, Integer> deserializeTree(String fileName) {
        TreeMap<String, Integer> searchTree = new TreeMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            searchTree = (TreeMap<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return searchTree;
    }

    private static String getStringValue(Cell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return "";
        }
    }

    private static List<String> findAndPrintMatchingEntries(TreeMap<String, Integer> searchTree, String searchTerm, int countRes) {

        long startTime = System.currentTimeMillis();

        // Используем ceilingEntry для поиска наименьшего значения, большего или равного заданному ключу
        Map.Entry<String, Integer> entry = searchTree.ceilingEntry(searchTerm);
        AtomicInteger totalCount = new AtomicInteger();

        List<String> results = new ArrayList<>();
        if (entry != null && entry.getKey().startsWith(searchTerm)) {
            System.out.println("Найдены запросы для '" + searchTerm + "':");

            // Начинаем итерацию с найденного узла
            Iterator<Map.Entry<String, Integer>> iterator = searchTree.tailMap(entry.getKey(), true).entrySet().iterator();


            // Фильтруем и собираем узлы в список, сортируем по значению и выводим результаты
            searchTree.tailMap(entry.getKey(), true)
                    .entrySet()
                    .stream()
                    .filter(e -> e.getKey().startsWith(searchTerm))
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e -> {
                        System.out.println(e.getKey() + ", количество: " + e.getValue());
                        if((long) results.size() != countRes){
                            results.add(e.getKey());
                        }
                        totalCount.getAndIncrement();
                    });
        } else {
            System.out.println("Запрос не найден для: " + searchTerm);
        }
        System.out.println("Кол-во производных для запроса " + searchTerm + " - " + totalCount + "\n");

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Время поиска ключей: " + elapsedTime + " миллисекунд");
        return results;
    }


}
