FROM node:16-alpine

WORKDIR /frontend/mp_front

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3000

CMD npm run dev