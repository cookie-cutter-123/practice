LINTER_VERSION := v1.61.0
LINTER_BIN := ./bin/golangci-lint

# Install the linter locally in your project's bin directory
install-linter:
	mkdir -p ./kode-kloud-go/bin
	curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh | sh -s -- -b ./kode-kloud-go/bin $(LINTER_VERSION)

# Run the linter
lint: install-linter
	cd kode-kloud-go && $(LINTER_BIN) run ./...

# Format the Go code using gofmt
format:
	find kode-kloud-go -name '*.go' -exec gofmt -w {} \;

# Lint and format the code
lint-and-format: lint format