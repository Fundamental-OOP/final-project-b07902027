clean:
	rm src/Main.class
	rm src/*/*/*.class
	rm src/*/*/*/*.class
	rm src/*/*.class
run:
	cd src && javac -d . Main.java && java Main