

class Analizador {

    int[] arr;
    int length;
    int comparaciones = 0;
    String currentAlgo = "";
    double tiempo = 0;
    long time = 0;


    // no aleatorio, linear crecimiento, un tamano
    public Analizador() {

        this.arr = new int[100];

        int c = 0;

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = c++;
        }

    }


    // aleatorio, tamano dinamico
    public Analizador(int size) {

        this.arr = new int[size];
        this.length = arr.length;

        int c = 0;

        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = (int) ((Math.random() * ((c++) - 0)));
        }
    }


    void burbuja() {
        int i, j, aux;
        this.currentAlgo = "Burbuja";
        this.comparaciones = 0;
        this.tiempo = 0;

        long startTime = System.nanoTime();

        for (i = 0; i < this.length-1; i++) {
            j = 0;
            while(j < this.length - i - 1) {
                if (this.arr[j] > this.arr[j + 1]) {
                    aux = this.arr[j];
                    this.arr[j] = this.arr[j + 1];
                    this.arr[j + 1] = aux;
                }
                j++;
                this.comparaciones++;
            }
        }

        this.time = System.nanoTime() - startTime;
    }

    void select() {

        this.currentAlgo = "Select"; // ...
        this.comparaciones = 0;
        this.tiempo = 0;

        long startTime = System.nanoTime();

        for (int i = 0; i < this.arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < this.arr.length; j++) {
                if (this.arr[j] < this.arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = this.arr[i];
            arr[i] = this.arr[minIndex];
            this.arr[minIndex] = temp;

            this.comparaciones++;
        }
        this.time = System.nanoTime() - startTime;

    }


}

class App {


    static void main(String[] args) {

        Analizador arrayAleatorio = new Analizador(10);
        arrayAleatorio.burbuja();

        for (int i: arrayAleatorio.arr) {
            System.out.println(i);
        }
        

        System.out.println("Para: " + arrayAleatorio.currentAlgo);
        System.out.println("Comparaciones: " + arrayAleatorio.comparaciones);
        System.out.println("Tiempo: " + arrayAleatorio.time + "ns");


        Analizador arrayAleatorioDos = new Analizador(10);
        arrayAleatorioDos.select();

        for (int i: arrayAleatorioDos.arr) {
            System.out.println(i);
        }
        

        System.out.println("Para: " + arrayAleatorioDos.currentAlgo);
        System.out.println("Comparaciones: " + arrayAleatorioDos.comparaciones);
        System.out.println("Tiempo: " + arrayAleatorioDos.time + "ns");

    }

}