JAVADIR=../../po-uuilib-201708311009
JARNAME=m19-app

all:
	(cd src; javac -cp $(JAVADIR)/po-uuilib.jar:../../m19-core/m19-core.jar -encoding UTF-8 `find . -name \*.java`)
	#(cd src; javac -cp ../../po-uuilib/po-uuilib.jar:../../m19-core/m19-core.jar -encoding UTF-8 `find . -name \*.java`)
	(cd src; jar cf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java` )

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
