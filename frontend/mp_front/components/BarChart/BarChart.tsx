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
  const totalColors = Array(data.length).fill(barColor);  //тут мы делаем массив, в ктором элементы - это цвет столбца


  useEffect(() => {
    if (canvasRef.current) {
      const ctx = canvasRef.current.getContext('2d');
      if (ctx) {
        new Chart(ctx, {
          type: 'bar',
          
          data: {
            labels,
            datasets: [
              {
                label: title,
                data,
                backgroundColor: totalColors,       //сюда пихаем наш массив из цветов столбца
                
              },
            ],
          },
          options: {
            legend: {
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
                
              ]
            },
          },
        });
      }
    }
  }, [canvasRef]);

  return <canvas ref={canvasRef} />;
};

export default BarChart;
