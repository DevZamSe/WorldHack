package com.devzamse.worldhack

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.devzamse.worldhack.view.Finish

class InfoPage : AppCompatActivity() {

    private lateinit var imagen: ImageView
    private lateinit var sub: TextView
    private lateinit var title: TextView
    private lateinit var autor: TextView
    private lateinit var titles: String
    private lateinit var subs: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page)

        imagen = findViewById(R.id.imageView7)
        sub = findViewById(R.id.textView10)
        title = findViewById(R.id.textView9)
        autor = findViewById(R.id.textView11)

        titles = intent.getStringExtra("title")
        subs = intent.getStringExtra("sub")
        val image = intent.getIntExtra("imagen", 0)

        sub.text = subs

        val imagens = resources.getDrawable(image)
        imagen.setImageDrawable(imagens)

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val i = Intent(this, Finish::class.java)
            i.putExtra("foto", image)
            i.putExtra("author", subs)
            startActivity(i)
        }

        FilterDescription(title, autor)

    }

    @SuppressLint("SetTextI18n")
    private fun FilterDescription(title: TextView?, autor: TextView) {
        when (titles) {
            "The Hoobit" -> {
                autor!!.text = "J R R. TOLKIEN"
                title!!.text = "chapters  1-2  3-5  6-7  8-9   \n" +
                        "Bilbo Baggins is a hobbit who lives a quiet life, until it is upset by a visit from a wizard named Gandalf. He wants Bilbo to help a group of dwarves take back the Mountain from Smaug, a dragon. Bilbo is unsure he wants to help, but he is drawn into the adventure by Gandalf, who tells the dwarves Bilbo is a burglar.\n" +
                        "\n" +
                        "The thirteen dwarves are led by Thorin Oakenshield, whose grandfather left a map and key to the Mountain in the care of Gandalf. The group encounters a few setbacks, such as the loss of the pony carrying their food supplies. Another occurs when Bilbo and the dwarves are captured by trolls, but Gandalf manages, through some trickery to free them.\n" +
                        "\n" +
                        "One night the group is forced to take shelter in a cave during a bad storm. The cave is the home of goblins, who capture them. Gandalf helps them escape, but Bilbo is left behind, after he is knocked unconscious.\n" +
                        "\n" +
                        "He stumbles on a ring in the tunnel and puts it into his pocket. Later his path is blocked by a lake and he meets Gollum, a creature owns the ring and wants to eat Bilbo. Gollum tries to trick Bilbo by cheating, after Bilbo wins a riddle game, by trying to eat him, instead of showing him the way out of the mountain. It is then Bilbo finds out the ring can make him invisible and he uses this power to sneak past Gollum and out of the mountain.\n" +
                        "\n" +
                        "Bilbo returns to the others, but he does not tell them about the ring. As they continue on their quest, they are besieged by a large group of Wargs, wild wolves who are friends of goblins. The party climbs tall trees to escape them, but the goblins arrive and try to set fire to the trees. At last the Lord of the Eagles and his guards arrive and carry them to safety.\n" +
                        "\n" +
                        "They travel next to the home of Beorn, a skin-changer, he can change into a bear. He agrees to help them travel to the gate of Mirkwood, a dangerous forest. The dwarves are told to stay on the path as they travel through Mirkwood. This is also the point where Gandalf leaves the group to go to a meeting.\n" +
                        "\n" +
                        "As they travel the dwarves and Bilbo find they have very little food. After seeing some lights in the forest they decide to leave the path to find food, but instead are captured by giant spiders. The spiders spin them into webs, but Bilbo using his sword frees himself and the others. They realize Thorin is missing and find he has been taken prisoner by the Wood-elves and soon all the dwarves are prisoners.\n" +
                        "\n" +
                        "Bilbo using the ring sneaks into the Wood-elf castle and devices a plan to free the dwarves. He puts the dwarves in wine barrels and throws himself and them through a trap door into the river, which flows to the Lake-town where men live.\n" +
                        "\n" +
                        "The people of Lake-town help the newly freed dwarves and Bilbo reach the Lonely Mountain where Smaug lives. The group finds their way up the Mountain and reach an area where the secret entrance is hiding. They open the entrance and Bilbo, using the ring, sneaks into Smaug's lair stealing a cup from the treasure. Smaug is angry and flies out of the Mountain looking for the dwarves, who hide in the tunnel.\n" +
                        "\n" +
                        "Bilbo goes back to Smaug's home, this time Smaug knows he is there and talks to him. Bilbo angers Smaug, who then flies out to harm the Lake-men, but first he smashes the secret entrance. Luckily the group is safely huddled in the tunnel as Smaug smashes the entrance.\n" +
                        "\n" +
                        "After a while, the group decides to go to Smaug's lair and find he is not there. Thorin wants to find the Arkenstone; he doesn't know Bilbo found it and is keeping it. The party leaves and go to an old out-look post to rest.\n" +
                        "\n" +
                        "Two days before in Lake-town, Smaug is killed by Bard. News soon spreads to the elves, goblins, and Beorn of Smaug's death, so they all want the treasure.\n" +
                        "\n" +
                        "The Wood-elves help the Lake-town people and travel with them to the Mountain, because they think the dwarves are dead and they want the treasure. A raven named Roäc arrives to tell the dwarves what has and is happening. Thorin declares no one will take the treasure, so he has the group barricade themselves inside the Mountain.\n" +
                        "\n" +
                        "Bard and the elves arrive to take the treasure only to be told they cannot have it. Bard tells them he will not allow provisions to be delivered to them inside the Mountain.\n" +
                        "\n" +
                        "Bilbo, tired of waiting for something to happen, delivers the Arkenstone to the Lake-men and elves to use as a bargaining tool against Thorin. Bilbo also sees Gandalf as Bilbo is leaving the camp. The next day Bard and the Elvenking tell Thorin they will exchange the stone for a share of the treasure. Gandalf persuades Thorin to agree to not hurt Bilbo, because he gave the Arkenstone to Bard. Thorin decides to give Bilbo his share of the treasure, which can be divided between the Lake-men and the elves.\n" +
                        "\n" +
                        "Dain, a dwarf, and his men arrive and a battle ensues between them and those camped outside the Mountain. As they fight, the goblins and wild wolves arrive and the Battle of the Five Armies ensues. The Eagles and Beorn help the dwarves, men, and elves win, but Thorin dies.\n" +
                        "\n" +
                        "Afterward, Bilbo and Gandalf return to Bilbo's home and Bilbo is left alone to live his life quietly, just the way he likes it.\n" +
                        "\n" +
                        "The Hobbit is a book full of adventure, but it also has an underlying theme of perseverance and how former foes can work together to defeat a common enemy. It also shows how undertaking different experiences allow people to grow in ways they did not think possible.\n"
            }
            "The Institute" -> {
                autor!!.text = "Stephen King"
                title!!.text = "Twelve-year-old Luke Ellis is abducted in the middle of the night in a quiet neighborhood of Minneapolis, after having murdered his parents. An operation that lasts less than two minutes. Luke wakes up in the sinister institution known as The Institute, in a room that resembles his but without windows. In similar rooms there are other children: Kalisha, Nick, George, Iris and Avery Dixon, among others, who share special abilities such as telekinesis or telepathy. All of them are housed in the Front Half of the institution. The older ones, on the other hand, are in the Back Half. As Kalisha says: \"You go in there but you don't go out.\" Mrs. Sigsby, the director, and the rest of the staff dedicate themselves without mercy to taking advantage of the paranormal talent of the kids. If you behave well they reward you. If not, the punishment is brutal. Luke realizes that the victims are disappearing and being transferred to the Back Half, so he becomes obsessed with escaping and asking for help. But nobody has ever escaped from The Institute ... Debtor of Ojos de fuego and with a cast of youthful characters (as in It and Stand By Me) with whom we can empathize, The Institute immediately reminds us of the best King, even Although it deals with subjects as dark as those that are making the headlines today and that make us fear for our future."
            }
            else -> {
                autor!!.text = "F. Scott Fitzcerald"
                title!!.text = "Nick Carraway, a young man from Minnesota, moves to New York in the summer of 1922 to learn about the bond business. He rents a house in the West Egg district of Long Island, a wealthy but unfashionable area populated by the new rich, a group who have made their fortunes too recently to have established social connections and who are prone to garish displays of wealth. Nick’s next-door neighbor in West Egg is a mysterious man named Jay Gatsby, who lives in a gigantic Gothic mansion and throws extravagant parties every Saturday night.\n" +
                        "\n" +
                        "Nick is unlike the other inhabitants of West Egg—he was educated at Yale and has social connections in East Egg, a fashionable area of Long Island home to the established upper class. Nick drives out to East Egg one evening for dinner with his cousin, Daisy Buchanan, and her husband, Tom, an erstwhile classmate of Nick’s at Yale. Daisy and Tom introduce Nick to Jordan Baker, a beautiful, cynical young woman with whom Nick begins a romantic relationship. Nick also learns a bit about Daisy and Tom’s marriage: Jordan tells him that Tom has a lover, Myrtle Wilson, who lives in the valley of ashes, a gray industrial dumping ground between West Egg and New York City. Not long after this revelation, Nick travels to New York City with Tom and Myrtle. At a vulgar, gaudy party in the apartment that Tom keeps for the affair, Myrtle begins to taunt Tom about Daisy, and Tom responds by breaking her nose.\n" +
                        "\n" +
                        "As the summer progresses, Nick eventually garners an invitation to one of Gatsby’s legendary parties. He encounters Jordan Baker at the party, and they meet Gatsby himself, a surprisingly young man who affects an English accent, has a remarkable smile, and calls everyone “old sport.” Gatsby asks to speak to Jordan alone, and, through Jordan, Nick later learns more about his mysterious neighbor. Gatsby tells Jordan that he knew Daisy in Louisville in 1917 and is deeply in love with her. He spends many nights staring at the green light at the end of her dock, across the bay from his mansion. Gatsby’s extravagant lifestyle and wild parties are simply an attempt to impress Daisy. Gatsby now wants Nick to arrange a reunion between himself and Daisy, but he is afraid that Daisy will refuse to see him if she knows that he still loves her. Nick invites Daisy to have tea at his house, without telling her that Gatsby will also be there. After an initially awkward reunion, Gatsby and Daisy reestablish their connection. Their love rekindled, they begin an affair.\n" +
                        "\n" +
                        "After a short time, Tom grows increasingly suspicious of his wife’s relationship with Gatsby. At a luncheon at the Buchanans’ house, Gatsby stares at Daisy with such undisguised passion that Tom realizes Gatsby is in love with her. Though Tom is himself involved in an extramarital affair, he is deeply outraged by the thought that his wife could be unfaithful to him. He forces the group to drive into New York City, where he confronts Gatsby in a suite at the Plaza Hotel. Tom asserts that he and Daisy have a history that Gatsby could never understand, and he announces to his wife that Gatsby is a criminal—his fortune comes from bootlegging alcohol and other illegal activities. Daisy realizes that her allegiance is to Tom, and Tom contemptuously sends her back to East Egg with Gatsby, attempting to prove that Gatsby cannot hurt him.\n" +
                        "\n" +
                        "When Nick, Jordan, and Tom drive through the valley of ashes, however, they discover that Gatsby’s car has struck and killed Myrtle, Tom’s lover. They rush back to Long Island, where Nick learns from Gatsby that Daisy was driving the car when it struck Myrtle, but that Gatsby intends to take the blame. The next day, Tom tells Myrtle’s husband, George, that Gatsby was the driver of the car. George, who has leapt to the conclusion that the driver of the car that killed Myrtle must have been her lover, finds Gatsby in the pool at his mansion and shoots him dead. He then fatally shoots himself.\n" +
                        "\n" +
                        "Nick stages a small funeral for Gatsby, ends his relationship with Jordan, and moves back to the Midwest to escape the disgust he feels for the people surrounding Gatsby’s life and for the emptiness and moral decay of life among the wealthy on the East Coast. Nick reflects that just as Gatsby’s dream of Daisy was corrupted by money and dishonesty, the American dream of happiness and individualism has disintegrated into the mere pursuit of wealth. Though Gatsby’s power to transform his dreams into reality is what makes him “great,” Nick reflects that the era of dreaming—both Gatsby’s dream and the American dream—is ov"
            }
        }
    }
}
