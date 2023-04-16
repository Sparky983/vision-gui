rootProject.name = "vision-gui"

sequenceOf("vision-api").forEach { include(it) }
