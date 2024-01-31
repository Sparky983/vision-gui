rootProject.name = "vision-gui"

sequenceOf(
    "examples:paper",
    "vision-api",
    "vision-paper"
).forEach { include(it) }
