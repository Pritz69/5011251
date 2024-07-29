package exercise_2_FactoryDesignPatternExample;

public class DocumentFactoryProvider {
    public static DocumentFactory getFactory(String documentType) {
        switch (documentType.toLowerCase()) {
            case "word":
                return new WordDocumentFactory();
            case "pdf":
                return new PdfDocumentFactory();
            case "excel":
                return new ExcelDocumentFactory();
            default:
                throw new IllegalArgumentException("Unknown document type: " + documentType);
        }
    }
}
