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
    data: PlayersType[] | undefined,
    setData: (data: any) => void,
    loading: boolean,
    setLoading: (loading: boolean) => void,
    error: Error | undefined,
    setError: (error: Error | undefined) => void,
    selectedPlayer: string | undefined,
    setSelectedPlayer: (player: string | undefined) => void
}

export const DataContext = React.createContext<DataContextProps | undefined>(undefined);

export const DataProvider = (props: {children: ReactNode}) => {
    const [data, setData] = useState<PlayersType[] | undefined>(undefined);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<Error | undefined>(undefined);
    const [selectedPlayer, setSelectedPlayer] = useState<string | undefined>(undefined);

    return (
      <DataContext.Provider value={{
        data: data,
        setData: setData,
        loading: loading,
        setLoading: setLoading,
        error: error,
        setError: setError,
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

