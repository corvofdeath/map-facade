package builders;

import domain.entities.Item;

public class ItemBuilder {

	private Item item;
	
	public static ItemBuilder mockItem() {
		ItemBuilder builder = new ItemBuilder();
		builder.item = new Item("maçã", 10);
		
		return builder;
	}
	
	public Item getItem() {
		return this.item;
	}
}
