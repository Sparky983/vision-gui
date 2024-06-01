rootProject.name = "vision-gui"

sequenceOf(
    "examples:minestom",
    "examples:paper",
    "vision-api",
    "vision-minestom",
    "vision-paper"
).forEach { include(it) }
