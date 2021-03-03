package structural;

public class Adapter {
    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
        cardReader.copyDataWithUsbCable();
    }
}

interface USB {
    void connectWithUsbCable();
    void copyDataWithUsbCable();
}

class MemoryCard {
    public void insert() {
        System.out.println("Card is inserted!");
    }

    public void copyData() {
        System.out.println("Data was copied!");
    }
}

// Adapter
class CardReader implements USB {

    private final MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        memoryCard.insert();

    }

    @Override
    public void copyDataWithUsbCable() {
        memoryCard.copyData();
    }
}
