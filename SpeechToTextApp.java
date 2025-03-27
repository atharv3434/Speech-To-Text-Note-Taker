import java.util.Scanner;

public class SpeechToTextApp {
    private static SpeechRecorder recorder = new SpeechRecorder();
    private static NoteStorage storage = new NoteStorage();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🎤 AI-Powered Speech-to-Text Note Taker 🎤");

        while (true) {
            System.out.println("\n1. Record New Note");
            System.out.println("2. View Saved Notes");
            System.out.println("3. Delete a Note");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    recorder.recordAudio();
                    break;
                case 2:
                    storage.viewNotes();
                    break;
                case 3:
                    storage.deleteNote();
                    break;
                case 4:
                    System.out.println("Exiting... Keep taking notes! 📝");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
