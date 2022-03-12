package com.PA.GadgetAPI.computer.internet;

import com.PA.GadgetAPI.DeviceUtils;
import net.minecraft.util.math.BlockPos;

public class Network {

    private BlockPos start;
    private BlockPos end;
    private float signalStrength;

    public Network(BlockPos start, BlockPos end){
        this.start = start;
        this.end = end;
        signalStrength = DeviceUtils.calcDistanceBlockPos(start,end);
    }
}
