#!/bin/bash

# Dừng và xóa các container Docker đang chạy
docker compose down

# Build Docker image bằng Maven
mvn compile jib:dockerBuild

# Khởi động lại các container Docker
docker compose up -d

# Đợi 5 giây
sleep 5

# Kết nối mạng Docker
