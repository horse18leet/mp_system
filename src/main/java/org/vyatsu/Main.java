//package org.vyatsu;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.vyatsu.seo.SearchWord;

//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;

//public class Main {
//    public static void main(String[] args){
//
//        int id = 168677430;
//        String url = "https://www.wildberries.ru/catalog/" + id + "/detail.aspx?targetUrl=SP";
//

//        CharSequence text = "Чудесный выбор для стильных женщин, готовых встретить осень. Кардиган обладает особым очарованием, который придаст вашему облику нежности и элегантности, идеально подходя как для повседневной носки, так и для особых случаев. Это не просто кардиган, это настоящая гордость вашего гардероба. В нем совмещаются классический стиль с изысканными элементами, такими как укороченный силуэт и широкий V-образный вырез, который делает его неповторимым. Средняя длина рукавов придает этой модели универсальность, делая ее актуальной в любое время года. Его легко ухаживать: рекомендуется стирать вручную или в машине при низкой температуре, чтобы сохранить первоначальный вид изделия. Высококачественные материалы гарантируют долговечность и стойкость, а его универсальный крой подходит для различных типов фигур. Этот кардиган – настоящая находка для современных женщин, которые ценят комфорт и стиль. Вы точно не пожалеете о своем выборе!";
//        Map<String, Integer> words = SearchWord.getSearchWordByDescription(text);
//        System.out.println(words.toString());
//
//    }
//
//}
