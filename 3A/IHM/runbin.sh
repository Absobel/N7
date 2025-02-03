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

# Run the test executable
./compiled_bins/$agent "$name" "$wifi_interface" "$port"

