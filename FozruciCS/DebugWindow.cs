using System.Windows.Forms;
using org.pircbotx;
using org.pircbotx.hooks.events;

namespace FozruciCS {
	public class DebugWindow : Form {
		public PircBotX UpdateBot;
		public string CurrentNick{ set; get; }
		public ConnectEvent ConnectEvent{ get; set; }
		public string Message{ get; set; }

		public DebugWindow(ConnectEvent @event, Network network, FozruciX fozruciX){
			throw new System.NotImplementedException();
		}

	}
}