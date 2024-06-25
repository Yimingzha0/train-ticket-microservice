import csv
import re

# Define the log filename and output CSV filename
log_filename = 'results/locust_requests_20240625200527.log'
csv_filename = 'results/locust_requests.csv'

# Define a regular expression pattern to extract the relevant information
log_pattern = re.compile(
    r'\[(?P<timestamp>[\d\-:\s,]+)]\s+[^\]]+/INFO/locust:\s+(?P<status>SUCCESS|FAILURE):\s+(?P<method>\w+)\s+(?P<endpoint>[\S]+)\s+(?P<response_time>[\d.]+)ms\s+(?P<size>\d+)\s+bytes'
)

# Open the log file and read lines
with open(log_filename, 'r') as log_file:
    log_lines = log_file.readlines()

# Extract relevant information and write to CSV
with open(csv_filename, 'w', newline='') as csv_file:
    csv_writer = csv.writer(csv_file)
    # Write the header
    csv_writer.writerow(['Timestamp', 'Method', 'Endpoint', 'Response Time (ms)', 'Size (bytes)'])

    for line in log_lines:
        match = log_pattern.search(line)
        if match:
            timestamp = match.group('timestamp').strip()
            method = match.group('method').strip()
            endpoint = match.group('endpoint').strip()
            response_time = match.group('response_time').strip()
            size = match.group('size').strip()
            # Write the extracted information to the CSV file
            csv_writer.writerow([timestamp, method, endpoint, response_time, size])

print(f"Log data has been successfully converted to {csv_filename}")
