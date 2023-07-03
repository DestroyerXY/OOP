# import datetime
# import json
# from Note import Note


# class NoteManager:
#     def __init__(self):
#         self.notes = []

#     def add_note(self, title, body):
#         new_id = len(self.notes) + 1
#         created = datetime.datetime.now()
#         new_note = Note(new_id, title, body, created)
#         self.notes.append(new_note)
#         return new_note

#     def delete_note(self, note_id):
#         for note in self.notes:
#             if note.id == note_id:
#                 self.notes.remove(note)
#                 return True
#         return False

#     def update_note(self, note_id, new_title, new_body):
#         for note in self.notes:
#             if note.id == note_id:
#                 note.update(new_title, new_body)
#                 return True
#         return False

#     def filter_notes_by_date(self, date):
#         filtered_notes = []
#         for note in self.notes:
#             if note.created.date() == date.date() or note.last_updated.date() == date.date():
#                 filtered_notes.append(note)
#         return filtered_notes

#     def save_notes_to_file(self, filename):
#         note_data = []
#         for note in self.notes:
#             note_data.append({
#                 'id': note.id,
#                 'title': note.title,
#                 'body': note.body,
#                 'created': note.created.strftime("%Y-%m-%d %H:%M:%S"),
#                 'last_updated': note.last_updated.strftime("%Y-%m-%d %H:%M:%S")
#             })
#         with open(filename, 'w') as file:
#             json.dump(note_data, file)

#     def load_notes_from_file(self, filename):
#         with open(filename, 'r') as file:
#             note_data = json.load(file)
#         for data in note_data:
#             note = Note(data['id'], data['title'], data['body'], datetime.datetime.strptime(data['created'], "%Y-%m-%d %H:%M:%S"))
#             note.last_updated = datetime.datetime.strptime(data['last_updated'], "%Y-%m-%d %H:%M:%S")
#             self.notes.append(note)


# def main():
#     note_manager = NoteManager()

#     command = input("Введите команду: ")

#     while command != "exit":
#         if command == "add":
#             title = input("Введите заголовок заметки: ")
#             body = input("Введите тело заметки: ")
#             note = note_manager.add_note(title, body)
#             print("Заметка успешно сохранена")

#         elif command == "delete":
#             note_id = int(input("Введите ID заметки для удаления: "))
#             if note_manager.delete_note(note_id):
#                 print("Заметка успешно удалена")
#             else:
#                 print("Заметка с указанным ID не найдена")

#         elif command == "update":
#             note_id = int(input("Введите ID заметки для редактирования: "))
#             new_title = input("Введите новый заголовок заметки: ")
#             new_body = input("Введите новое тело заметки: ")
#             if note_manager.update_note(note_id, new_title, new_body):
#                 print("Заметка успешно отредактирована")
#             else:
#                 print("Заметка с указанным ID не найдена")
        
#         elif command == "filter":
#             date_str = input("Введите дату для фильтрации (в формате ГГГГ-ММ-ДД): ")
#             try:
#                 date = datetime.datetime.strptime(date_str, "%Y-%m-%d").date()
#                 filtered_notes = note_manager.filter_notes_by_date(date)
#                 print("Найденные заметки:")
#                 for note in filtered_notes:
#                     print(f"ID: {note.id}")
#                     print(f"Title: {note.title}")
#                     print(f"Body: {note.body}")
#                     print(f"Created: {note.created}")
#                     print(f"Last updated: {note.last_updated}")
#                     print()
#             except ValueError:
#                 print("Некорректный формат даты")
        
#         command = input("Введите команду: ")

#     note_manager.save_notes_to_file("notes.json")

# if __name__ == "__main__":
#     main()

import datetime
import json
from mailbox import NotEmptyError
from Note import Note


class NoteManager:
    def __init__(self):
        self.notes = []

    def add_note(self, title, body):
        new_id = len(self.notes) + 1
        created = datetime.datetime.now()
        new_note = Note(new_id, title, body, created)
        self.notes.append(new_note)
        return new_note

    def delete_note(self, note_id):
        for note in self.notes:
            if note.id == note_id:
                self.notes.remove(note)
                return True
        return False

    def update_note(self, note_id, new_title, new_body):
        for note in self.notes:
            if note.id == note_id:
                note.update(new_title, new_body)
                return True
        return False

    def filter_notes_by_date(self, date):
        filtered_notes = []
        for note in self.notes:
            if note.created.date() == date or note.last_updated.date() == date:
                filtered_notes.append(note)
        return filtered_notes

    def save_notes_to_file(self, filename):
        note_data = []
        for note in self.notes:
            note_data.append({
                'id': note.id,
                'title': note.title,
                'body': note.body,
                'created': note.created.strftime("%Y-%m-%d %H:%M:%S"),
                'last_updated': note.last_updated.strftime("%Y-%m-%d %H:%M:%S")
            })
        with open(filename, 'w') as file:
            json.dump(note_data, file)

    def load_notes_from_file(self, filename):
        with open(filename, 'r') as file:
            note_data = json.load(file)
        for data in note_data:
            note = Note(data['id'], data['title'], data['body'], datetime.datetime.strptime(data['created'], "%Y-%m-%d %H:%M:%S"))
            note.last_updated = datetime.datetime.strptime(data['last_updated'], "%Y-%m-%d %H:%M:%S")
            self.notes.append(note)

    def show_all_notes(self):
        for note in self.notes:
            print(f"ID: {note.id}")
            print(f"Title: {note.title}")
            print(f"Body: {note.body}")
            print(f"Created: {note.created}")
            print(f"Last updated: {note.last_updated}")
            print()


def main():
    note_manager = NoteManager()

    command = input("Введите команду: ")

    while command != "exit":
        if command == "add":
            title = input("Введите заголовок заметки: ")
            body = input("Введите тело заметки: ")
            note = note_manager.add_note(title, body)
            print("Заметка успешно сохранена")

        elif command == "delete":
            note_id = int(input("Введите ID заметки для удаления: "))
            if note_manager.delete_note(note_id):
                print("Заметка успешно удалена")
            else:
                print("Заметка с указанным ID не найдена")

        elif command == "update":
            note_id = int(input("Введите ID заметки для редактирования: "))
            new_title = input("Введите новый заголовок заметки: ")
            new_body = input("Введите новое тело заметки: ")
            if note_manager.update_note(note_id, new_title, new_body):
                print("Заметка успешно отредактирована")
            else:
                print("Заметка с указанным ID не найдена")
        
        elif command == "filter":
            date_str = input("Введите дату для фильтрации (в формате ГГГГ-ММ-ДД): ")
            try:
                date = datetime.datetime.strptime(date_str, "%Y-%m-%d").date()
                filtered_notes = note_manager.filter_notes_by_date(date)
                print("Найденные заметки:")
                for note in filtered_notes:
                    print(f"ID: {note.id}")
                    print(f"Title: {note.title}")
                    print(f"Body: {note.body}")
                    print(f"Created: {note.created}")
                    print(f"Last updated: {note.last_updated}")
                    print()
            except ValueError:
                print("Некорректный формат даты")
        
        elif command == "show":
            note_manager.show_all_notes()
        
        command = input("Введите команду: ")

    note_manager.save_notes_to_file("notes.json")

if __name__ == "__main__":
    main()