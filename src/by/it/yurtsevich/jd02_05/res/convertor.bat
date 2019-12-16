/*
У меня установлена 12я Java, в которой нет утилиты native2ascii, поэтому я заполнил файлы .properties вручную, предварительно
сконвертировав текст через онлайн версию native2ascii (https://native2ascii.net/)
*/
native2ascii -encoding utf-8 strings.txt strings_en-EN.properties
native2ascii -encoding utf-8 string_be_BY.txt strings_be-BY.properties
native2ascii -encoding utf-8 string_ru_RU.txt strings_ru-RU.properties
