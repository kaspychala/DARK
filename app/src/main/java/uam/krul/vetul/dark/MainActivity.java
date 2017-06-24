package uam.krul.vetul.dark;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button A;
    private TextView questionA;
    private Button B;
    private TextView questionB;
    private Button C;
    private TextView questionC;
    private Button D;
    private TextView questionD;
    private Button start;
    private TextView question;
    private String questions[][] = new String[42][6];
    private Random generator = new Random();
    private int random = generator.nextInt(42);
    private String answer = "";
    private float score = 0;
    private boolean started=false;
    private float questionNumber = 1;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillQuestions();

        A = (Button) findViewById(R.id.A);
        A.setEnabled(false);
        questionA = (TextView) findViewById(R.id.questionA);
        B = (Button) findViewById(R.id.B);
        B.setEnabled(false);
        questionB = (TextView) findViewById(R.id.questionB);
        C = (Button) findViewById(R.id.C);
        C.setEnabled(false);
        questionC = (TextView) findViewById(R.id.questionC);
        D = (Button) findViewById(R.id.D);
        D.setEnabled(false);
        questionD = (TextView) findViewById(R.id.questionD);
        start = (Button) findViewById(R.id.start);
        question = (TextView) findViewById(R.id.question);
        image = (ImageView) findViewById(R.id.reactions);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!started) {
                    A.setEnabled(true);
                    B.setEnabled(true);
                    C.setEnabled(true);
                    D.setEnabled(true);
                    question.setTextColor(Color.BLACK);
                    questionA.setTextColor(Color.BLACK);
                    questionB.setTextColor(Color.BLACK);
                    questionC.setTextColor(Color.BLACK);
                    questionD.setTextColor(Color.BLACK);
                    question.setText(questions[random][0]);
                    questionA.setText(questions[random][1]);
                    questionB.setText(questions[random][2]);
                    questionC.setText(questions[random][3]);
                    questionD.setText(questions[random][4]);
                    start.setEnabled(false);
                    start.setText("Następne pytanie");
                    image.setImageResource(R.drawable.blank);
                    started = true;
                }
                else{
                    if(questionNumber>15){
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Czy Vetul będzie zadowolony?");
                        alertDialog.setMessage("Twój wynik to: "+(score/(questionNumber-1))*100+"%");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        started=false;
                        questionNumber = 0 ;
                        score = 0;
                        image.setImageResource(R.drawable.blank);
                        A.setEnabled(false);
                        B.setEnabled(false);
                        C.setEnabled(false);
                        D.setEnabled(false);
                        start.setText("Rozpocznij test!");
                    }
                    else{
                        question.setTextColor(Color.BLACK);
                        questionA.setTextColor(Color.BLACK);
                        questionB.setTextColor(Color.BLACK);
                        questionC.setTextColor(Color.BLACK);
                        questionD.setTextColor(Color.BLACK);
                        question.setText(questions[random][0]);
                        questionA.setText(questions[random][1]);
                        questionB.setText(questions[random][2]);
                        questionC.setText(questions[random][3]);
                        questionD.setText(questions[random][4]);
                        A.setEnabled(true);
                        B.setEnabled(true);
                        C.setEnabled(true);
                        D.setEnabled(true);
                        start.setEnabled(false);
                        image.setImageResource(R.drawable.blank);
                    }
                }
            }
        });

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer="a";
                check();
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer="b";
                check();
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer="c";
                check();
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer="d";
                check();
            }
        });

    }

    public void check(){
        if(questions[random][5].equals(answer)){
            score++;
            image.setImageResource(R.drawable.happy);
            question.setText("DOBRZE!");
            question.setTextColor(Color.GREEN);
        }
        else{
            image.setImageResource(R.drawable.sad);
            question.setText("ŹLE!");
            question.setTextColor(Color.RED);
        }
        if(questions[random][5].equals("a")){
            questionA.setTextColor(Color.GREEN);
            questionB.setTextColor(Color.RED);
            questionC.setTextColor(Color.RED);
            questionD.setTextColor(Color.RED);

        }
        if(questions[random][5].equals("b")){
            questionA.setTextColor(Color.RED);
            questionB.setTextColor(Color.GREEN);
            questionC.setTextColor(Color.RED);
            questionD.setTextColor(Color.RED);

        }
        if(questions[random][5].equals("c")){
            questionA.setTextColor(Color.RED);
            questionB.setTextColor(Color.RED);
            questionC.setTextColor(Color.GREEN);
            questionD.setTextColor(Color.RED);

        }
        if(questions[random][5].equals("d")){
            questionA.setTextColor(Color.RED);
            questionB.setTextColor(Color.RED);
            questionC.setTextColor(Color.RED);
            questionD.setTextColor(Color.GREEN);

        }
        random = generator.nextInt(42);
        start.setEnabled(true);
        questionNumber++;
        if(questionNumber>15){
            start.setText("Zakończ i podaj wynik");
        }
        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
    }

    public void fillQuestions(){
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 1
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[0][0] = "Ile bajtów w pamięci programu mikrokontrolera 8051 zajmuje rozkaz MOV R5, A ?";
            questions[0][1] = "a. 1";
            questions[0][2] = "b. 2";
            questions[0][3] = "c. 3";
            questions[0][4] = "d. 4";
            questions[0][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 2
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[1][0] = "Architektura pamięci mikrokontrolera 8051 to tzw. architektura mieszana. Oznacza to: ";
            questions[1][1] = "a. Wspólną pamięć dla danych i programu oraz wspólną magistralę dla danych i adresów. ";
            questions[1][2] = "b. Wspólną pamięć dla danych i programu, ale oddzielne magistrale danych i adresową.";
            questions[1][3] = "c. Oddzielne pamięci danych i programu, ale wspólną magistralę danych i adresową. ";
            questions[1][4] = "d. Oddzielne pamięci danych i programu oraz oddzielne magistrale danych i adresową.";
            questions[1][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 3
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[2][0] = "Jak należy ustawić starszy (TH) i młodszy (TL) bajt timera T0, aby pracując w trybie 1 zliczył 256impulsów? ";
            questions[2][1] = "a. TH = 0, TL = 0  ";
            questions[2][2] = "b. TH = 255, TL = 0 ";
            questions[2][3] = "c. TH = 0, TL = 255";
            questions[2][4] = "d. TH = 255, TL = 255";
            questions[2][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 4
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[3][0] = "Sygnał ALE mikrokontrolera 8051, to sygnał sterujący: ";
            questions[3][1] = "a. zapisem do zewnętrznej pamięci programu ";
            questions[3][2] = "b. odczytem z zewnętrznej pamięci programu ";
            questions[3][3] = "c. zatrzaskiem (buforem) adresowym";
            questions[3][4] = "d. przekierowaniem sygnałów WR i RD do pamięci danych lub programu";
            questions[3][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 5
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[4][0] = "W systemie DSM-51 wpisanie liczby 00000110B do rejestru CSDB spowoduje: ";
            questions[4][1] = "a. wyświetlenie cyfry 1 na wybranych wskaźnikach wyświetlacza siedmiosegmentowego ";
            questions[4][2] = "b. wybranie wskaźników 1 i 2 wyświetlacza siedmiosegmentowego ";
            questions[4][3] = "c. możliwość odczytu klawiszy  oraz ESC klawiatury przeglądanej sekwencyjnie ";
            questions[4][4] = "d. możliwość odczytu klawiszy 1 oraz 2 klawiatury matrycowej ";
            questions[4][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 6
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[5][0] = "Dane są następujące instrukcje asemblera ARM mov r1, #17 mov r2, #2048- mov r3, r2, ASR r1. Rejestr r3 zawiera wynik";
            questions[5][1] = "a. Dzielenia r2 przez 2^r1 ";
            questions[5][2] = "b. Arytmetycznego przesunięcia w prawo o 17 bitów w rejestrze r2 ";
            questions[5][3] = "c. Dzielenia r2 przez 2 ";
            questions[5][4] = "d. Mnożenia r2 przez 217 ";
            questions[5][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 7
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[6][0] = "Procesor ARM jest zbudowany wg modelu ";
            questions[6][1] = "a. Architektury von Neumana ";
            questions[6][2] = "b. Architektury harwardzkiej ";
            questions[6][3] = "c. Architektury mieszanej, noszącej cechy architektury von Neumana i harwardzkiej ";
            questions[6][4] = "d. Innej niż w punktach a-c ";
            questions[6][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 8
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[7][0] = "Instrukcja Add r0, r1, r1, LSL #5 wykonywana jest przez CPU ARM na";
            questions[7][1] = "a. Pięciu operandach";
            questions[7][2] = "b. Czterech operandach";
            questions[7][3] = "c. Trzech operandach (drugi wykład Snape’a) ";
            questions[7][4] = "d. Dwóch operandach ";
            questions[7][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 9
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[8][0] = "Dane są instrukcje (procesor ARM):  cmp r1,r2  blt procedura  add r0, r1,r2  b dalej procedura:  bl FUNKCJA dalej: .... Wywołanie funkcji nastąpi jeśli w rejestrze CPSR ";
            questions[8][1] = "a. Wartość znacznika N=1";
            questions[8][2] = "b. Wartość znacznika C=1";
            questions[8][3] = "c. Wartość znacznika Z=1";
            questions[8][4] = "d. Wartość znacznika V=1";
            questions[8][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 10
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[9][0] = "Licznik rozkazów (PC) mikrokontrolera 8051 zawiera";
            questions[9][1] = "a. adres bajtu w pamięci programu kolejnego do pobrania";
            questions[9][2] = "b. numer rozkazu (kod operacji) kolejnego do wykonania";
            questions[9][3] = "c. ilość rozkazów wykonanych w trakcie działania programu ";
            questions[9][4] = "d. ilość rozkazów dostępnych dla danego typu mikrokontrolera";
            questions[9][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 11
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[10][0] = "Termin ‘multipleksowanie’ w odniesieniu do magistrali oznacza";
            questions[10][1] = "a. wykorzystanie tych samych linii do przesyłania danych oraz adresów ";
            questions[10][2] = "b. wykorzystanie tych samych linii do przesyłania informacji pomiędzy więcej niż dwoma urządzeniami";
            questions[10][3] = "c. podział magistrali na magistralę danych, magistralę adresową oraz linie sterujące ";
            questions[10][4] = "d. podział urządzeń korzystających z magistrali na urządzenia typu ‘master’ oraz ‘slave’";
            questions[10][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 12
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[11][0] = "Sterownik transmisji szeregowej mikrokontrolera 8051 pracuje w trybie 1 (transmisja asynchroniczna) z prędkością 240 bodów. Ile bajtów danych w ciągu jednej sekundy nadaje (odbiera)?";
            questions[11][1] = "a. 240";
            questions[11][2] = "b. 120";
            questions[11][3] = "c. 30";
            questions[11][4] = "d. 24";
            questions[11][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 13
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[12][0] = "Dekoder adresów zastosowany w systemie DSM-51 umożliwia pobieranie rozkazów (kodu programu) z pamięci danych. Jest to możliwe dzięki";
            questions[12][1] = "a. przekierowaniu sygnałów sterujących odczytem i zapisem danych (RD, WR) do pamięci programu (zamiast RAM) ";
            questions[12][2] = "b. przekierowaniu sygnału odczytu z pamięci programu (PSEN) do pamięci danych (zamiast ROM)";
            questions[12][3] = "c. zastosowaniu zatrzasku (bufora) adresowego umożliwiającego multipleksowanie magistrali";
            questions[12][4] = "d. żadne z powyższych";
            questions[12][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 14
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[13][0] = "Pod adresem 102H w pamięci programu mikrokontrolera 8051 znajduje się rozkaz SJMP 0FEH. Spod jakiego adresu zostanie pobrany następny rozkaz wykonywany w trakcie działania tego programu?";
            questions[13][1] = "a. 100H";
            questions[13][2] = "b. 102H";
            questions[13][3] = "c. 200H";
            questions[13][4] = "d. 202H";
            questions[13][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 15
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[14][0] = "Architektura pamięci typu von Neumana charakteryzuje się: ";
            questions[14][1] = "a. oddzielnymi magistralami dla danych i adresów ";
            questions[14][2] = "b. wspólną magistralą dla danych i adresów oraz wspólną pamięcią dla danych i programu ";
            questions[14][3] = "c. rozdzieleniem pamięci danych i pamięci programu ";
            questions[14][4] = "d. 16-bitowym dostępem do pamięci programu";
            questions[14][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 16
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[15][0] = "Mnożenia przez 2^n, 2^n-1 i 2^n+1 można generować w procesorze ARM dzięki użyciu ";
            questions[15][1] = "a. 32-bitowego sumatora i cyklicznego rejestru przesuwnego ";
            questions[15][2] = "b. Cyklicznego rejestru przesuwneg";
            questions[15][3] = "c. Macierzy mnożników i 32- bitowego sumatora ";
            questions[15][4] = "d. 32-bitowego sumatora i cyklicznego rejestru przesuwnego lub macierzy mnożników ";
            questions[15][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 17
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[16][0] = "Cykliczny rejestr przesuwny w procesorze ARM umożliwia: ";
            questions[16][1] = "a. Mnożenie argumentów nie będących potęgami 2";
            questions[16][2] = "b. Mnożenie argumentów będących potęgami 3";
            questions[16][3] = "c. Mnożenie dwóch liczb, z których jedna nie jest potęgą 2";
            questions[16][4] = "d. Rotację o n bitów w lewo ";
            questions[16][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 18
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[17][0] = "Cykliczny rejestr przesuwny w procesorze ARM umożliwia: ";
            questions[17][1] = "a. Dzielenie przez potęgę dwójki ";
            questions[17][2] = "b. Rotację o n bitów w lewo ";
            questions[17][3] = "c. Mnożenie argumentów nie będących potęgami 2 ";
            questions[17][4] = "d. Mnożenie argumentów będących potęgami 3 ";
            questions[17][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 19
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[18][0] = "Rozkaz ‘MOV 5, R3’ w pamięci programu mikrokontrolera 8051 zostanie zapisany jako:  ";
            questions[18][1] = "a. wyłącznie kod operacji (numer rozkazu) ";
            questions[18][2] = "b. kod operacji oraz liczba ‘5’ ";
            questions[18][3] = "c. kod operacji oraz adres rejestru R3  ";
            questions[18][4] = "d. kod operacji, liczba ‘5’ oraz adres rejestru R3 ";
            questions[18][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 20
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[19][0] = "W składni instrukcji as ARM [mnemonik operand1, operand2, operand3] operandy 1, 2 i 3 muszą spełniać następujące warunki: ";
            questions[19][1] = "a. Operand1 i operand2 muszą być rejestrami operand3 może być wartością skalowania ";
            questions[19][2] = "b. Operand1 musi być rejestrem, operand2 i operand3 mogą być rejestrami";
            questions[19][3] = "c. Operand1, operand2, operand3 muszą być rejestrami ";
            questions[19][4] = "d. Operand1 i operand3 muszą być rejestrami operand2 może być rejestrem";
            questions[19][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 21
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[20][0] = "W składni instrukcji as ARM [mnemonik operand1, operand2, operand3] operandy 1, 2 i 3 muszą spełniać następujące warunki: ";
            questions[20][1] = "a. Operand1, operand2, operand3 muszą być rejestrami ";
            questions[20][2] = "b. Operand1 musi być rejestrem, operand2 i operand3 mogą być rejestrami";
            questions[20][3] = "c. Operand1 i operand2 muszą być rejestrami operand3 może być rejestrem ";
            questions[20][4] = "d. Operand1 i operand2 mogą być rejestrami operand3 może być wartością skalowania ";
            questions[20][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 22
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[21][0] = "Który z poniższych rejestrów mikrokontrolera 8051 jest rejestrem 16-bitowym? ";
            questions[21][1] = "a. Akumulator (ACC)";
            questions[21][2] = "b. Akumulator pomocniczy (B) ";
            questions[21][3] = "c. Wskaźnik stosu (SP) ";
            questions[21][4] = "d. Licznik rozkazów (PC) ";
            questions[21][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 23
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[22][0] = "Który z poniższych rejestrów mikrokontrolera 8051 jest rejestrem 16-bitowym? ";
            questions[22][1] = "a. Akumulator pomocniczy (B) ";
            questions[22][2] = "b. Akumulator (ACC)  ";
            questions[22][3] = "c. Wskaźnik danych (DPTR) ";
            questions[22][4] = "d. Rejestr stanu (PSW)  ";
            questions[22][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 24
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[23][0] = "W którym z poniższych rozkazów mikrokontrolera 8051 zastosowano adresowanie natychmiastowe?  ";
            questions[23][1] = "a. RL A";
            questions[23][2] = "b. INC @R0";
            questions[23][3] = "c. MOV R1, 16H";
            questions[23][4] = "d. MOV ACC, #0";
            questions[23][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 25
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[24][0] = "Timer T1 mikrokontrolera 8051 pracując w trybie 0 zlicza: ";
            questions[24][1] = "a. cykle maszynowe";
            questions[24][2] = "b. impulsy zegarowe";
            questions[24][3] = "c. cykle rozkazowe";
            questions[24][4] = "d. żadne z powyższych";
            questions[24][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 26
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[25][0] = "Sterownik transmisji szeregowej mikrokontrolera 8051 pracuje w trybie 1 (transmisja asynchroniczna) z prędkością 240 bodów. Ile bajtów danych w ciągu jednej sekundy nadaje (odbiera)? ";
            questions[25][1] = "a. 240";
            questions[25][2] = "b. 120";
            questions[25][3] = "c. 12";
            questions[25][4] = "d. 24";
            questions[25][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 27
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[26][0] = "Mnożenia przez 2^n, 2^n-1 i 2^n+1 można generować w procesorze ARM dzięki użyciu ";
            questions[26][1] = "a. Macierzy mnożników i 32- bitowego sumatora";
            questions[26][2] = "b. Cyklicznego rejestru przesuwnego";
            questions[26][3] = "c. 32-bitowego sumatora i cyklicznego rejestru przesuwnego lub macierzy mnożników";
            questions[26][4] = "d. Banku rejestrów i jednostki sterującej";
            questions[26][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 28
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[27][0] = "Pod adresem 102H w pamięci programu mikrokontrolera 8051 znajduje się rozkaz SJMP 0FEH. Spod jakiego adresu zostanie pobrany następny rozkaz wykonywany w trakcie działania tego programu?  ";
            questions[27][1] = "a. 102H";
            questions[27][2] = "b. 100H";
            questions[27][3] = "c. 200H";
            questions[27][4] = "d. 202H";
            questions[27][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 29
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[28][0] = "Dekoder adresów zastosowany w systemie DSM-51 umożliwia pobieranie rozkazów (kodu rogramu) z pamięci danych. Jest to możliwe dzięki";
            questions[28][1] = "a. żadna nie jest poprawna";
            questions[28][2] = "b. przekierowaniu sygnałów sterujących odczytem i zapisem danych (RD, WR) do pamięci programu (zamiast RAM)";
            questions[28][3] = "c. zastosowaniu zatrzasku (bufora) adresowego umożliwiającego multipleksowanie magistrali";
            questions[28][4] = "d. b. przekierowaniu sygnału odczytu z pamięci programu (PSEN) do pamięci danych (zamiast ROM)";
            questions[28][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 30
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[29][0] = "Instrukcja sub r0, r1, r1, LSL #5 jest wykonywana w procesorze ARM w";
            questions[29][1] = "a. W macierzy mnożników i w ALU";
            questions[29][2] = "b. W banku rejestrów, w cyklicznym rejestrze przesuwnym i w ALU";
            questions[29][3] = "c. ALU";
            questions[29][4] = "d. W cyklicznym rejestrze przesuwnym";
            questions[29][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 31
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[30][0] = "Przejście na początek pętli do kolejnej iteracji instrukcji wykonywanych przez procesor ARM jest wykonywane bezpośrednio po";
            questions[30][1] = "a. Rozgałęzieniu i złączeniu";
            questions[30][2] = "b. Rozgałęzieniu bezwarunkowym ";
            questions[30][3] = "c. Zignorowaniu rozgałęzienia warunkowego";
            questions[30][4] = "d. Zignorowaniu rozgałęzienia i złączenia";
            questions[30][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 32
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[31][0] = "Dla procesora ARM";
            questions[31][1] = "a. Pojedynczy rozkaz procesora wykonuje kilka operacji.";
            questions[31][2] = "b. Rozkazy wymagają od kilku do kilkunastu cykli zegara.";
            questions[31][3] = "c. Wykonywanie rozkazów polega na operowaniu wyłącznie na rejestrach.";
            questions[31][4] = "d. Rozkazy mogą operować bezpośrednio na pamięci.";
            questions[31][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 33
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[32][0] = "Rozgałęzienie i złączenie (ARM)";
            questions[32][1] = "a. Jest powiązane z umieszczeniem adresu powrotu w liczniku programu (rejestrze PC).";
            questions[32][2] = "b. Zmianą w rejestrze CPSR.";
            questions[32][3] = "c. Oznacza zakończenie wykonania programu.";
            questions[32][4] = "d. Oznacza wyjście z procedury do programu głównego.";
            questions[32][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 34
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[33][0] = "Każda modyfikacja rejestru PC w banku rejestrów procesora ARM skutkuje wykonanieminstrukcji przesuniętej względem bieżącego adresu PC";
            questions[33][1] = "a. o 1 bajt";
            questions[33][2] = "b. o 4 bajt";
            questions[33][3] = "c. o 2 bajt";
            questions[33][4] = "d. o 8 bajt";
            questions[33][5] = "d";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 35
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[34][0] = "W których z poniższych rozkazów mikrokontrolera 8051 zastosowano adresowanie bezpośrednie? ";
            questions[34][1] = "a. RLC A";
            questions[34][2] = "b. DEC @R1";
            questions[34][3] = "c. CJNE A, 10H, 16H  ";
            questions[34][4] = "d. XRL A, #5";
            questions[34][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 36
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[35][0] = "Dekoder adresów zastosowany w systemie DSM-51 umożliwia pobieranie rozkazów (kodu programu) z pamięci danych. Jest to możliwe dzięki: ";
            questions[35][1] = "a. przekierowaniu sygnałów sterujących odczytem i zapisem danych (RD, WR) do pamięci programu (zamiast RAM) ";
            questions[35][2] = "b. przekierowaniu sygnału odczytu z pamięci programu (PSEN) do pamięci danych (zamiast ROM)";
            questions[35][3] = "c. zastosowaniu zatrzasku (bufora) adresowego umożliwiającego multipleksowanie magistrali ";
            questions[35][4] = "d. żadne z powyższych";
            questions[35][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 37
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[36][0] = "Liczba jednobajtowa 0FFH interpretowana w kodzie uzupełnieniowym do dwóch oznacza ";
            questions[36][1] = "a. 0";
            questions[36][2] = "b. -1";
            questions[36][3] = "c. 255";
            questions[36][4] = "d. -255";
            questions[36][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 38
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[37][0] = "Ile bajtów w pamięci programu mikrokontrolera 8051 zajmuje rozkaz MOV R5, A ?";
            questions[37][1] = "a. wyłącznie kod operacji (numer rozkazu) ";
            questions[37][2] = "b. kod operacji oraz liczba ‘5’ ";
            questions[37][3] = "c. kod operacji oraz adres rejestru R3 ";
            questions[37][4] = "d. kod operacji, liczba ‘5’ oraz adres rejestru R3 ";
            questions[37][5] = "b";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 39
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[38][0] = "Rozkaz ‘MOV 5, R3’ w pamięci programu mikrokontrolera 8051 zostanie zapisany jako: ";
            questions[38][1] = "a. 1";
            questions[38][2] = "b. 2";
            questions[38][3] = "c. 3";
            questions[38][4] = "d. 4";
            questions[38][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 40
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[39][0] = "Licznik rozkazów (PC) mikrokontrolera 8051 zawiera ";
            questions[39][1] = "a. adres bajtu w pamięci programu kolejnego do pobrania ";
            questions[39][2] = "b. numer rozkazu (kod operacji) kolejnego do wykonania ";
            questions[39][3] = "c. ilość rozkazów wykonanych w trakcie działania programu ";
            questions[39][4] = "d. ilość rozkazów dostępnych dla danego typu mikrokontrolera ";
            questions[39][5] = "a";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 41
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[40][0] = "Jak należy ustawić starszy (TH) i młodszy (TL) bajt timera T0, aby pracując w trybie 1 zliczył 256 impulsów? ";
            questions[40][1] = "a. TH = 0, TL = 0 ";
            questions[40][2] = "b. TH = 0, TL = 256 ";
            questions[40][3] = "c. TH = 256, TL = 0 ";
            questions[40][4] = "d. TH = 256, TL = 256 ";
            questions[40][5] = "c";
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ///////QUESTION 42
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            questions[41][0] = "Rejestr maski przerwań (IE) zawiera ";
            questions[41][1] = "a. adres procedury obsługi przerwania, którego żądanie pojawiło się jako ostatnie";
            questions[41][2] = "b. adres tablicy wektorów przerwań ";
            questions[41][3] = "c. zestaw bitów ustawiających priorytet przerwań od poszczególnych urządzeń ";
            questions[41][4] = "d. zestaw bitów włączających zezwolenia na przerwania od poszczególnych urządzeń ";
            questions[41][5] = "d";
    }
}
