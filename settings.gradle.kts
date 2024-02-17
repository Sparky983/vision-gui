rootProject.name = "vision-gui"

sequenceOf(
    "example",
    "vision-api",
    "vision-minestom",
    "vision-minestom:example",
    "vision-paper"
).forEach { include(it) }
