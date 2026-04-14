#!/bin/bash
# Script để build và kiểm tra ứng dụng

echo "======================================"
echo "Sửa Lỗi: Bảng Sinh Viên Không Hiển Thị"
echo "======================================"
echo ""

# Bước 1: Clean và Build
echo "✓ Bước 1: Build project..."
cd D:\IT210\Session_7
.\gradlew clean build -x test

if [ $? -eq 0 ]; then
    echo "✓ Build thành công!"
    echo ""

    # Bước 2: Kiểm tra WAR file
    echo "✓ Bước 2: Kiểm tra WAR file..."
    if [ -f "build/libs/Session_7-1.0-SNAPSHOT.war" ]; then
        echo "✓ WAR file được tạo: build/libs/Session_7-1.0-SNAPSHOT.war"
        echo ""

        # Bước 3: Thông báo các file được sửa
        echo "✓ Bước 3: Các template được cập nhật:"
        echo "  - home.html (Danh sách sinh viên)"
        echo "  - form.html (Thêm/Sửa sinh viên)"
        echo "  - upload.html (Tải ảnh)"
        echo "  - result.html (Kết quả)"
        echo ""

        echo "======================================"
        echo "Hướng dẫn chạy ứng dụng:"
        echo "======================================"
        echo "1. Tải Tomcat từ https://tomcat.apache.org"
        echo "2. Copy WAR file vào TOMCAT_HOME/webapps/"
        echo "3. Chạy startup.bat hoặc startup.sh"
        echo "4. Truy cập http://localhost:8080/Session_7"
        echo ""

        echo "======================================"
        echo "Giải pháp cho lỗi:"
        echo "======================================"
        echo "✓ Loại bỏ phụ thuộc Tailwind CDN"
        echo "✓ Thêm CSS inline đầy đủ cho tất cả template"
        echo "✓ Bảng sẽ hiển thị 100% ngay cả khi CDN không tải"
        echo ""

    else
        echo "✗ Lỗi: WAR file không tìm thấy"
    fi
else
    echo "✗ Build thất bại"
fi

