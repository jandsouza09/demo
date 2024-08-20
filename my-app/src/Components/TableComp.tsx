import { DataGrid, GridColDef, GridRowsProp } from '@mui/x-data-grid';
import { useDataContext } from '../Context/DataContext';
import { useEffect, useMemo } from 'react';

type TableCompProps = {
    rows: GridRowsProp,
    columns: GridColDef[],
    height?: number
}

const TableComp = () => {
    const { alldata, filterData, year } = useDataContext();
    const tableColumns = [
        { field: 'playerID', headerName: 'Player ID', width: 150 },
        { field: 'nameFirst', headerName: 'First Name', width: 150 },
        { field: 'nameLast', headerName: 'Last Name', width: 150 },
        { field: 'weight', headerName: 'Weight', width: 150 },
        { field: 'height', headerName: 'Height', width: 150 },
        { field: 'birthYear', headerName: 'Birth Year', width: 150 },
        { field: 'debut', headerName: 'Debut', width: 150 }
      ];
      const tableRows = useMemo(() => {
        if (year) {
            return filterData?.map(player => ({
                id: player.playerID,
                playerID: player.playerID,
                nameFirst: player.nameFirst,
                nameLast: player.nameLast,
                weight: player.weight,
                height: player.height,
                birthYear: player.birthYear,
                debut: player.debut
            }));
        }
        return alldata?.map(player => ({
            id: player.playerID,
            playerID: player.playerID,
            nameFirst: player.nameFirst,
            nameLast: player.nameLast,
            weight: player.weight,
            height: player.height,
            birthYear: player.birthYear,
            debut: player.debut
        }));
    },[alldata, filterData, year]);

    return (
        <div style={{ height: 600, width: '100%' }}>
            <DataGrid rows={tableRows} columns={tableColumns} />
        </div>
    );
};

export default TableComp;