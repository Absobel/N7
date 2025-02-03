#!/bin/bash
set -e

usage() {
    echo "Usage: $0 <agent> [<name>]"
    exit 1
}

# Check if exactly two arguments are provided
[ "$#" -ne 1 ] && [ "$#" -ne 2 ] && usage

agent="$1"
name="${2:-$agent}"
port=5670

# Find the current WiFi interface (first interface from 'iw dev')
wifi_interface=$(iw dev | awk '$1=="Interface"{print $2; exit}')
if [ -z "$wifi_interface" ]; then
    echo "No WiFi interface found."
    exit 1
fi

# Change to the agent folder
cd "$(dirname "${BASH_SOURCE[0]}")/$agent" || { echo "Directory $agent not found"; exit 1; }

# Build in Debug mode
cmake -S . -B build -DCMAKE_BUILD_TYPE=Debug
make -j8 -C build

# Build and package in Release mode
cmake -S . -B build -DCMAKE_BUILD_TYPE=Release
make -j8 -C build
make -j8 -C build package

# Run the test executable
./build/$agent "$name" "$wifi_interface" "$port"

