package by.it.komarov.jd01_12;

class Timer {
        private long iniTime;

    Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            double delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return "Время выполнения = " + delta + " мкрс";
        }
    }

