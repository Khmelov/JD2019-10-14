package by.it.protsko.calc;

import by.it.protsko.calc.lang_operations.ResurceManager;
import by.it.protsko.calc.lang_operations.VarMessages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();
    static VarCreator varCreator;                       ///////////////////////////

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_INPOSIBLE_OPERATION), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_INPOSIBLE_OPERATION), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_INPOSIBLE_OPERATION), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_INPOSIBLE_OPERATION), this, other));
    }

    static Map<String, Var> sortVar(Map<String, Var> vars) {
        return new TreeMap<>(vars);
    }

    static Var createVar(String stringVar) throws CalcException {
        stringVar.replaceAll(" ", "");

        int varType = VarTypeDeterminator.getTypeVar(stringVar);
        if (varType > 0) {
           return VarCreator.createVar(VarTypes.getByOrderCode(varType), stringVar);
        } else {
            if (vars.containsKey(stringVar)) {
                return vars.get(stringVar);
            }
        }
        throw new CalcException(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_CREATE_VAR));
    }

            static void saveCalcVariable () {
                try (PrintWriter writer = new PrintWriter(getFileName())) {
                    for (Map.Entry<String, Var> entry : vars.entrySet()) {
                        writer.printf("%s=%s\n", entry.getKey(), entry.getValue().toString());
                    }
                } catch (IOException e) {
                    System.out.println(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_SAVE_DATA_TO_FILE));
                }
            }


            static void loadCalcVariable () {
                try {
                    Parser parser = new Parser();
                    for (String line : Files.lines(Paths.get(getFileName()))
                            .collect(Collectors.toList())
                    ) {
                        parser.calc(line);

                    }
                } catch (IOException | CalcException e) {
                    System.out.println(ResurceManager.INSTANSE.getMessage(VarMessages.ERR_LOAD_DATA_FROM_FILE));
                }

            }

            private static String getFileName () {
                return System.getProperty("user.dir")
                        + File.separator + "src" + File.separator +
                        Var.class
                                .getName()
                                .replace(Var.class.getSimpleName(), "")
                                .replace(".", File.separator) + "varsValue.txt";
            }
        }
