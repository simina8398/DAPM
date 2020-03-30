Exercitiul 1 a reprezentat o mare problema pentru mine, pentru ca microfonul de la emulator
nu a functionat. Am vazut si ca exemplul dat in laborator era pentru WEAR. Nu am reusit sa 
rezolv problema si din ce am vorbit cu mai multi colegi, nu sunt singura.
Problema vine de la emulator, pentru ca pentru cei care au avut si dispozitiv real si au testat
acelasi cod, au realizat ca functioneaza.
Astfel, am testat text to Speech cu un string prestabilit in zona de text.

Asezarea in pagina a fost usoara, am folosit ConstraintLayout si am utilizat :
app:layout_constraintTop_toTopOf="parent" pentru butonul de Listen
app:layout_constraintBottom_toBottomOf="parent" pentru butonul de Mic

Pentru text am folosit ca si pentru butonul de Listen doar ca am mai adaugat :
android:layout_marginTop="124dp" ca sa fie asezat spre jumatatea ecranului.

In values:
-> in strings.xml pentru numele aplicatiei si pentru butoane.
-> in styles.xml am adaugat <item name="android:textAllCaps">false</item> pentru a nu mai avea
textele in capsLock.
-> in colors.xml am schimbat culorile pentru a semana cu exemplul dat in laborator.

Exercitiul 2 am adaugat un Linear Layout in interiorul lui activity_main.xml si i-am constrans
lungimea intre text si butonul de jos.
Am modificat numele pentru fragment ca acesta sa ia ca default Fragmentul1 si in plus fata de
tutorial, am adaugat layoutul de la fragment_one pentru a nu avea erori in activity_main.xml.
Am creeat cele 2 clase java si cele 2 xml-uri pentru fiecare fragment, conform cu tutorialul.
In final, am adaugat functia selectFrag in ActivityMain care foloseste functia :
fragmentTransaction.replace pentru a inlocui fragmentele, in functie de butonul apasat.