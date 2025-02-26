#!/bin/bash

# Navigate to the sample directory
cd "$(dirname "$0")"

# Function to display the menu
show_menu() {
    echo "Select an option:"
    echo "1) Start Docker Compose"
    echo "2) Stop Docker Compose"
    echo "3) Exit"
}

# Function to handle the user's choice
handle_choice() {
    case $1 in
        1)
            echo "Starting Docker Compose..."
            docker-compose -p news-community up --build -d
            ;;
        2)
            echo "Stopping Docker Compose..."
            docker-compose -p news-community down
            ;;
        3)
            echo "Exiting..."
            exit 0
            ;;
        *)
            echo "Invalid option. Please try again."
            ;;
    esac
}

show_menu
read -p "Enter your choice [1-3]: " choice
handle_choice $choice
