rootProject.name = "vision-gui"

sequenceOf(
    "examples:paper",
    "vision-api",
    "vision-minestom",
    "vision-minestom:example",
    "vision-paper"
).forEach { include(it) }
