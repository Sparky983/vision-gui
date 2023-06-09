rootProject.name = "vision-gui"

sequenceOf(
    "example",
    "vision-api",
    "vision-kotlin",
    "vision-paper"
).forEach { include(it) }
