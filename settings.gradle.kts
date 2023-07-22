rootProject.name = "vision-gui"

sequenceOf(
    "example",
    "vision-api",
    "vision-paper"
).forEach { include(it) }
