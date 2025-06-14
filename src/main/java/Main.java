import java.io.File;

import infrastructure.MAS;
import scriptcc.ScriptRunner;

public class Main {
    public static void main(String[] args) {
        scriptcc.ScriptRunner r = new ScriptRunner();
        File f = new File("src/main/asl/input.json");
        MAS system = r.createMas(f.getAbsolutePath(),false);
    }
}
