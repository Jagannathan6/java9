public class ProcessExample {

    public static void main(String args[]) {
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .forEach(ProcessExample::listInfo);

       ProcessHandle processHandle =  ProcessHandle.allProcesses()
                .filter(p -> p.info().command().map( c -> c.contains("TextEdit")).orElse(false))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Process Not Found"));

       System.err.println(processHandle.info());

        processHandle.onExit().thenAccept(h -> System.err.println("TextEdit is killed by Java "));

        boolean shutdown = processHandle.destroy();

        processHandle.onExit().join();

        System.err.println("Shutdown status " + shutdown);

    }

    public static void listInfo(ProcessHandle.Info info) {
        System.err.println(info.user() );
        if ( info.command().isPresent()){
            System.err.println(info.command().get());
        }
    }
}
