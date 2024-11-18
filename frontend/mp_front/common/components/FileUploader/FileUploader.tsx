import { Button } from "../ui/button";
import { useState, useRef } from "react";



interface FileUploaderProps {
    allowedFormat: string
}

export default function FileUploader({ allowedFormat }: FileUploaderProps) {
  const fileInputRef = useRef<HTMLInputElement>(null);
  const [isDragActive, setIsDragActive] = useState(false);
  const [selectedFile, setSelectedFile] = useState<File | null>(null);

  const handleButtonClick = () => {
    fileInputRef.current?.click();
  };

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const file = event.target.files?.[0];
    if (file) {
      setSelectedFile(file);
    }
  };

  const handleDragOver = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    setIsDragActive(true);
  };

  const handleDragLeave = () => {
    setIsDragActive(false);
  };

  const handleDrop = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    setIsDragActive(false);
    const file = event.dataTransfer.files[0];
    if (file) {
      setSelectedFile(file);
    }
  };

  const removeCurrentFile = () => {
    setSelectedFile(null)
  }

  const handleSaveMedia = () => {
    
  }

  return (
    <div className="flex flex-col justify-between">
      <input
        ref={fileInputRef}
        type="file"
        className="hidden"
        accept={allowedFormat}
        onChange={handleFileChange}
      />

      <div
        onDragOver={handleDragOver}
        onDragLeave={handleDragLeave}
        onDrop={handleDrop}
        className={`border-2 rounded-md w-[205px] h-[300px] mb-[20px] ${
          isDragActive ? "border-blue-500 bg-blue-100" : "border-gray-300"
        }`}
      >
        {selectedFile ? (
          <p className="text-gray-700 text-base w-[100%] text-center">{selectedFile.name}</p>
        ) : (
            <Button onClick={handleButtonClick} variant="outline" className="w-full h-full p-0">
              Добавте фото или видео
            </Button>
        )}
      </div>
      <div className="flex flex-col gap-[15px]">
        <Button variant="default" disabled={!selectedFile}>Сохранить</Button>
        <Button variant="destructive" disabled={!selectedFile} onClick={removeCurrentFile}>Отменить</Button>
      </div>
    </div>
  );
}
