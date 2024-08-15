FROM node:18-alpine as builder
WORKDIR /home/node/app
COPY public public
COPY src src
COPY package-lock.json .
COPY package.json .
COPY tailwind.config.js .

ARG BACKEND_BASE_URL

ENV BACKEND_BASE_URL http://backend:8080/api

RUN npm ci
RUN npm run build

FROM nginx:1.24-alpine as server
COPY --from=builder /home/node/app/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]