package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class hello {
    
    @Usage("Say Hello")
    @Command
    def main(InvocationContext context) {
        for (entry in context.getAttributes().entrySet()) {
            println entry
        }
        return "Hello"
    }
    
}
