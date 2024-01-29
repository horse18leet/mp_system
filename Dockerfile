FROM nginx:stable

COPY ssl-certs/ /etc/nginx/ssl/
COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]