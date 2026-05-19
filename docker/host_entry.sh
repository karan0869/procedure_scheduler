#!/bin/bash
echo "host entry "
hosts="$1"

hostlist=${hosts//@/ }
IFS="#" read -ra split_host <<< "$hostlist"

hostfile="/etc/hosts"
# Write split values into the specified file
for value in "${split_host[@]}"; do
    echo "$value" >> "$hostfile"
done
echo "${split_host[@]} have been written to $hostfile."