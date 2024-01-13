//это первая версия графика, никитос попросил новый сделать, пока не буду удалять

import React, { useEffect, useRef } from 'react';
import Chart from 'chart.js';
import { BorderWidthIcon } from '@radix-ui/react-icons';

interface BarChartProps {
  data: number[];
  labels: string[];
  title: string;
}

const BarChart: React.FC<BarChartProps> = ({ data, labels, title}) => {
  const canvasRef = useRef<HTMLCanvasElement>(null);

  const barColor = "#adfa1d"
  const totalColors = Array(data.length).fill(barColor);  //тут мы делаем массив, в котором элементы - это цвет столбца


  useEffect(() => {
    if (canvasRef.current) {
      const ctx = canvasRef.current.getContext('2d');
      if (ctx) {
        new Chart(ctx, {
          type: 'bar',
          
          data: {
            labels,                                 //заголовки столбцов
            datasets: [
              {
                label: title,                       //заголовок графика
                data,                               //данные по оси y
                backgroundColor: totalColors,       //массив из цветов столбца
              },
            ],
          },
          options: {
            legend: {
              labels: {
                boxWidth: 0,
                fontSize: 18
              },
              display: true,
            },
            scales: {
              yAxes: [
                {
                  ticks: {
                    beginAtZero: true,
                  },
                },
              ],
              xAxes: [
                {
                  ticks: {
                    fontSize: 10,
                    callback: function(value, index, ticks) {  //если длина лейбла больше 5, то обрезаем его и добавляем точки
                      if (String(value).length > 5) {
                        return (String(value).substring(6) + "...");
                      }
                      return value;
                    }
                    
                  }
                }
              ],
            },
          },
        });
      }
    }
  }, [canvasRef]);

  return <canvas ref={canvasRef} />;
};

export default BarChart;
