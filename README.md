To reproduce

Publish to maven local the PR branch

curl -X POST --data-binary @/path/to/some/huge/file http://localhost:8080 -H "Content-Type: application/octet-stream"

