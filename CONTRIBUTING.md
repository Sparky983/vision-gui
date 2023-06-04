# Contributing Guidelines

When contributing to Vision GUI, we require that you adhere to these guidelines for:
1. [Commit Messages](#commit-messages)
2. [Pull Requests](#pull-requests)
3. [Conventions](#conventions)

## Commit Messages

There is no strict format for commit messages since they will be squashed when merged into master.
However, please try to keep them short and descriptive.

## Pull Requests

Before opening a pull request, please ensure that no duplicate pull requests exist. If one does, 
please comment on the existing pull request beforehand.

### Unwanted Changes

- Large code refactors
- Micro-optimizations

### Draft Pull Requests

If you are working on a feature and want to open a pull request to get feedback, please mark it as
a draft.

## Conventions

### Code Style

- Set your editor to follow the [.editorconfig](.editorconfig)
- In general, if you are unsure about a style choice, follow the conventions of other code

### Javadoc Style

- All public API should be documented with Javadoc
- Use `<p>` between paragraphs
- Try to use our custom tags wherever possible:
  - `@vision.experimental` - to explain why an API is marked with `@ApiStatus.Internal`
  - `@vision.apiNote` - to make notes about documentation that isn't part of the API specification
  - `@vision.implNote` - to explain implementation details
  - `@vision.examples` - to provide examples of how to use an API
- Avoid HTML entities, instead use `@literal`

### Tests

- Everything is required to be tested except `vision-paper` 
- Use `@Nested` to group tests

#### Naming

- Test classes should end with `Tests`

### Annotations

- Use `@ApiStatus.Experimental` to mark unstable APIs
- `@NullMarked` and `@Nullable` are required for all types
- `@VisibleForTesting` is required for all elements that have had their visibility promoting due to
testing
