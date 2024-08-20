import React, { Provider, useEffect, useState } from "react";
import { ReactElement, ReactNode, createContext, useContext } from "react";

export type PlayersType = {
  playerID: string,
  nameFirst: string,
  nameLast: string,
  weight: string,
  height: string,
  birthYear: string,
  debut: string
}

type DataContextProps = {
    alldata: PlayersType[] | undefined,
    setAllData: (data: PlayersType[] | undefined) => void,
    filterData: PlayersType[] | undefined,
    setFilterData: (data: PlayersType[] | undefined) => void,
    year: number | undefined,
    setYear: (year: number | undefined) => void,
    selectedPlayer: string | undefined,
    setSelectedPlayer: (player: string | undefined) => void
}

export const DataContext = React.createContext<DataContextProps | undefined>(undefined);

export const DataProvider = (props: {children: ReactNode}) => {
    const [allData, setAllData] = useState<PlayersType[] | undefined>(undefined);
    const [filterData, setFilterData] = useState<PlayersType[] | undefined>(undefined);
    const [year, setYear] = useState<number | undefined>(undefined);
    const [selectedPlayer, setSelectedPlayer] = useState<string | undefined>(undefined);

    return (
      <DataContext.Provider value={{
        alldata: allData,
        setAllData: setAllData,
        filterData: filterData,
        setFilterData: setFilterData,
        year: year,
        setYear: setYear,
        selectedPlayer: selectedPlayer,
        setSelectedPlayer: setSelectedPlayer
      }}>
        {props.children}
      </DataContext.Provider>
    )
}

export const useDataContext = () => {
    const context = useContext(DataContext);
    if (!context) {
        throw new Error("Data Context missing");
    }
    return context;
}

