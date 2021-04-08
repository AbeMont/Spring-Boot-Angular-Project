import { Item } from "./item";

export interface Cart {
    id: number;
    address: string;
    name: string;
    items: Item[];
}
