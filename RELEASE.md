# Release Instructions

## Major/Minor Release

1. Check TODOs and ensure there is nothing that needs to be done before release
2. Check the milestone for the current release and ensure there are no remaining issues
3. On a new branch, create a commit updating the version in the following places:
    - gradle.properties
    - README.md
        - Installation
    - docs/README.md
      - Javadoc links
      - Installation
4. Create a tag for the preceding commit of the format `v<major>.<minor>.<patch>` (e.g. v1.2.3)
5. Create a merge request into main and merge when ready
6. Create a GitHub release pertaining to the given release. Attach related binaries. Use the
   following description template:
    ```md
    # What’s Changed
    - <changes>
    
    # Dependency Information
    - [Javadoc](<Javadoc Link>)
    - Maven: [me.sparky983:vision-api](<repositlite-link>)
    ```
7. Close the milestone and create a new one for the next minor version if one does not already exist
8. Create a new branch for continued patches to the current minor version named 
   `ver/<major>.<minor>.x` (e.g. ver/1.2.x)
9. Change the documentation branch to the newly created branch
10. Create a [developmental release](#developmental-release)

## Developmental Release

1. On a new branch, create a commit updating the version in the following places:
   - gradle.properties
   - docs/README.md
     - Javadoc links
     - Installation
2. Create a marge request into main and merge when ready

# Versioning

- This project uses [semantic versioning](https://semver.org/)
- What is considered breaking is generally up to the discretion of the developer, however there are
  a few exceptions:
  - If an element is marked with `@org.jetbrains.annotations.ApiStatus.Experimental`, it is free to
    be modified or removed without a major release
  - If an element has been marked with `@Deprecated(forRemoval = true)` for at least one minor 
    version, it may be removed without a major release
  - Source or binary incompatibilities are always considered breaking
  - If an element is marked with `@org.jetbrains.annotations.ApiStatus.NonExtendable`, new methods
    may be added to the class without a major release
