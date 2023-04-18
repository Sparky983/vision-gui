rootProject.name = "vision-gui"

sequenceOf(
    "vision-api",
    "vision-paper"
).forEach { include(it) }
