package com.massivecraft.factions.cmd;

import java.util.Collections;

import com.massivecraft.factions.cmd.req.ReqHasFaction;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.Perm;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsPlayer;
import com.massivecraft.massivecore.ps.PS;

public class CmdFactionsUnclaim extends FactionsCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFactionsUnclaim()
	{
		// Aliases
		this.addAliases("unclaim");

		// Requirements
		this.addRequirements(ReqHasPerm.get(Perm.UNCLAIM.node));
		this.addRequirements(ReqHasFaction.get());
		this.addRequirements(ReqIsPlayer.get());
	}

	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform()
	{
		// Args
		PS chunk = PS.valueOf(me).getChunk(true);
		Faction newFaction = FactionColl.get().getNone();

		// Apply
		if (msender.tryClaim(newFaction, Collections.singletonList(chunk))) return;
	}
	
}
