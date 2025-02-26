#!/bin/bash

# Function to display the menu
show_menu() {
    echo "Select a service to run:"
    echo "1) Clean All "
    echo "2) Auth Service"
    echo "3) News Service"
    echo "4) Core Service"
    echo "5) Exit"
}

# Function to run the selected service
run_service() {
    case $1 in
        1)
            echo "Running All Service..."
            mvn clean install
            ;;
        2)
            echo "Running Auth Service..."
            cd auth
            mvn spring-boot:run
            ;;      
        3)
            echo "Running News Service..."
            cd news
            mvn spring-boot:run -Dspring-boot.run.arguments=--debug
            ;;                  
        4)
            echo "Running Core Service..."
            cd core
            mvn spring-boot:run -Dspring-boot.run.arguments=--debug
            ;;
        5)
            echo "Exiting..."
            exit 0
            ;;
        *)
            echo "Invalid option. Please try again."
            ;;
    esac
}

show_menu
read -p "Enter your choice [1-5]: " choice
run_service $choice