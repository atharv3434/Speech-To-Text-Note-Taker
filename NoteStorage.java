import java.io.*;
import java.util.*;

public class NoteStorage {
    private static final String NOTES_FILE = "notes.txt";

    public void saveNote(String note) {
        try (FileWriter fw = new FileWriter(NOTES_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(note);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving note: " + e.getMessage());
        }
    }

    public void viewNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            int noteNum = 1;
            System.out.println("\n📂 Saved Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println(noteNum++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ No notes found.");
        }
    }

    public void deleteNote() {
        try {
            List<String> notes = new ArrayList<>(Files.readAllLines(new File(NOTES_FILE).toPath()));
            if (notes.isEmpty()) {
                System.out.println("📂 No notes to delete.");
                return;
            }

            Scanner sc = new Scanner(System.in);
            viewNotes();
            System.out.print("Enter note number to delete: ");
            int noteIndex = sc.nextInt() - 1;

            if (noteIndex >= 0 && noteIndex < notes.size()) {
                notes.remove(noteIndex);
                Files.write(new File(NOTES_FILE).toPath(), notes);
                System.out.println("✅ Note deleted successfully!");
            } else {
                System.out.println("❌ Invalid selection.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error deleting note.");
        }
    }
}
