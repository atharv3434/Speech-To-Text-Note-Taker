# Speech-To-Text-Note-Taker


🗣 AI-Powered Speech-to-Text Note Taker 
A console-based Speech-to-Text Note Taking Application that records audio, converts it into text, and saves it as a note. This project is built entirely in Java and uses Google Speech-to-Text API for real-time transcription.


📂 Project Structure

SpeechToTextNotes/
│── SpeechToTextApp.java   (Main Application)
│── SpeechRecorder.java    (Handles Audio Recording)
│── SpeechProcessor.java   (Converts Audio to Text)
│── NoteStorage.java       (Handles Note Saving & Retrieval)


🔑 API Key Required
Google Cloud Speech-to-Text API – Get API Key Here

Replace SpeechClient.create() with your API key setup

🎯 How It Works?
Record Audio 🎤

User speaks, system records audio

Convert to Text 📝

Uses Google Speech-to-Text API

Save & View Notes 📂

Notes stored in a file for future reference

Delete Notes 🗑

Users can manage their saved notes

🚀 How to Run?
Set up Google Cloud Speech-to-Text API

Compile: javac *.java

Run: java SpeechToTextApp

Start Recording & Taking Notes! 🎙

🎯 Future Enhancements
✔ 🎨 GUI Version (Java Swing for Better UX)
✔ 🌍 Multi-Language Support
